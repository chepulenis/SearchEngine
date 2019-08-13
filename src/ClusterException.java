public class ClusterException extends RuntimeException{
    public ClusterException(String error) {
        System.out.println(error);
        System.out.println("Cluster is empty");
        getCause();
    }
}
