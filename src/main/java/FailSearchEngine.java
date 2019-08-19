
import java.util.List;

public class FailSearchEngine {


    public void search(Cluster cluster){
        List<Server> serverList = cluster.getServerList();
        int startServer = 0;
        int endServer = serverList.size();
        int currentServer = 0;

        while (endServer - startServer > 1){
            currentServer = (startServer + endServer) / 2;
            if (serverList.get(currentServer).isFailed()){
                endServer = currentServer;
            }
            else{
                startServer = currentServer;
            }
        }

        if(!serverList.get(startServer).isFailed()){
            currentServer = endServer;
        }
        else currentServer = startServer;

        List<Node> nodeList = serverList.get(currentServer).getNodeList();
        int startNode = 0;
        int endNode = nodeList.size();
        int currentNode = 0;

        while (endNode - startNode > 1){
            currentNode = (startNode + endNode) / 2;
            if (nodeList.get(currentNode).isFailed()){
                endNode = currentNode;
            }
            else{
                startNode = currentNode;
            }
        }

        if(!nodeList.get(startNode).isFailed()){
            currentNode = endNode;
        }
        else currentNode = startNode;

        System.out.println("First failed server is #" + currentServer + " with node #" + currentNode);
    }


}
