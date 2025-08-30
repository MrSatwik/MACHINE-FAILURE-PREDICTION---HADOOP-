import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class SensorDataMapper extends Mapper<LongWritable, Text, Text, Text> {
    private static final double TEMP_THRESHOLD = 75.0;
    private static final double VIBRATION_THRESHOLD = 50.0;
    private static final double PRESSURE_THRESHOLD = 100.0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Skip the header row
        if (key.get() == 0) {
            return;
        }

        String[] columns = value.toString().split(",");

        // Skip empty lines
        if (columns.length < 4) {
            return;
        }

        try {
            String machineId = columns[0].trim();
            double temperature = Double.parseDouble(columns[1].trim());
            double vibration = Double.parseDouble(columns[2].trim());
            double pressure = Double.parseDouble(columns[3].trim());

            // Check if any threshold is exceeded
            StringBuilder failureReason = new StringBuilder();
            if (temperature > TEMP_THRESHOLD) {
                failureReason.append("Temperature > 75, ");
            }
            if (vibration > VIBRATION_THRESHOLD) {
                failureReason.append("Vibration > 50, ");
            }
            if (pressure > PRESSURE_THRESHOLD) {
                failureReason.append("Pressure > 100, ");
            }

            // If failure condition exists, output the result
            if (failureReason.length() > 0) {
                failureReason.delete(failureReason.length() - 2, failureReason.length());  // Remove trailing comma
                context.write(new Text(machineId), new Text("Failure Expected: " + failureReason.toString()));
            }
        } catch (NumberFormatException e) {
            // Handle invalid numeric data
            System.err.println("Error parsing numeric values: " + value.toString());
        }
    }
}
