
public class Application {
    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        cluster.addServers(12);
        System.out.println(cluster);
        System.out.println("Sending message...");
        cluster.sendMessage();
        System.out.println(cluster);
        FailSearchEngine failSearchEngine = new FailSearchEngine();
        failSearchEngine.search(cluster);
    }
}
