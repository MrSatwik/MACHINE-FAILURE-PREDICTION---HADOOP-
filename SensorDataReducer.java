import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class SensorDataReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // Assuming we only have one failure reason per machine
        String failureMessage = "";
        for (Text value : values) {
            failureMessage = value.toString();
        }
        // Output the final failure message for each machine
        context.write(key, new Text(failureMessage));
    }
}
