import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cluster {

    private List<Server> serverList = new ArrayList<>();

    private static final Random RANDOM = new Random();


    public List<Server> getServerList() {
        return serverList;
    }

    public void sendMessage(){
        try {
        int randomServer = RANDOM.nextInt(serverList.size());
        serverList.get(randomServer).setFailed();
        List<Node> nodeList = serverList.get(randomServer).getNodeList();
        int randomNode = RANDOM.nextInt(nodeList.size());
            for (int i = randomNode; i < nodeList.size(); i++) {
                serverList.get(randomServer).getNodeList().get(i).setFailed();
            }
            for (int i = randomServer + 1; i < serverList.size(); i++) {
                List<Node> currentNodeList = serverList.get(i).getNodeList();
                serverList.get(i).setFailed();
                for (int j = 0; j < currentNodeList.size(); j++) {
                    currentNodeList.get(j).setFailed();
                }
            }
        }catch (Exception e){
            throw new ClusterException(e.getMessage());
        }
    }

    public void addServers(int randomCount) throws ClusterException{
        int serversQuantity = RANDOM.nextInt(randomCount);
        for (int i = 0; i < serversQuantity; i++){
            serverList.add(new Server(i,RANDOM.nextInt(randomCount)));
        }
    }

    @Override
    public String toString() {
        return "Cluster: {" +  serverList +
                '}';
    }
}
