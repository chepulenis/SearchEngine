import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class Application {
    static Gson gson = new Gson();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws ClusterException, IOException {

        Cluster cluster = new Cluster();
        cluster.addServers(10);
        System.out.println(cluster);
        System.out.println("Sending message...");
        cluster.sendMessage();
        System.out.println(cluster);
        FailSearchEngine failSearchEngine = new FailSearchEngine();
        failSearchEngine.search(cluster);

        jacksonWriteToJson(cluster,"JacksonLog.txt");
        jacksonReadFromJson("JacksonLog.txt");

        gsonWriteToJson(cluster, "GsonLog.txt");
        gsonReadFromJson("GsonLog.txt");
    }

    public static void jacksonWriteToJson(Cluster cluster, String file){
        try(FileWriter fileWriter = new FileWriter(file)){
            objectMapper.writeValue(fileWriter, cluster);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void jacksonReadFromJson(String file){
        try(FileReader fileReader = new FileReader(file)){
            Cluster cluster = objectMapper.readValue(fileReader, Cluster.class);
            System.out.println("From JSON by Jackson: " + cluster);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void gsonWriteToJson(Cluster cluster, String file){
        try(FileWriter fileWriter = new FileWriter(file)){
        gson.toJson(cluster, fileWriter);
        fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void gsonReadFromJson(String file){
        try(FileReader fileReader = new FileReader(file)){
            Cluster cluster = gson.fromJson(fileReader, Cluster.class);
            System.out.println("From JSON by Gson: " + cluster);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
