import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MachineFailurePrediction {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage: MachineFailurePrediction <input path> <output path>");
            System.exit(-1);
        }

        // Configure the job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Machine Failure Prediction");

        // Set the job's jar file
        job.setJarByClass(MachineFailurePrediction.class);

        // Set Mapper, Reducer classes
        job.setMapperClass(SensorDataMapper.class);
        job.setReducerClass(SensorDataReducer.class);

        // Set output key/value types
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // Set input and output paths
        FileInputFormat.addInputPath(job, new Path(args[0]));
        
        Path outputPath = new Path(args[1]);
        FileSystem fs = FileSystem.get(conf);
        
        // Delete the output directory if it exists
        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }

        FileOutputFormat.setOutputPath(job, outputPath);

        // Wait for the job to complete
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
