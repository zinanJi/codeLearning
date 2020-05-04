package solution.acm;

public class Dijkstra {
   /* *//** 邻接矩阵 *//*
    private int[][] matrix;
    *//** 表示正无穷 *//*
    private int MAX_WEIGHT = Integer.MAX_VALUE;
    *//** 顶点集合 *//*
    private String[] vertexes;
*/


    public void dijkstra(int[][] graph, int[] dis, boolean[] visited){

       // https://blog.csdn.net/weixin_40423553/article/details/79613820
        while(true){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<dis.length;i++){
                if(visited[i])
                    continue;
                else{
                    if(dis[i]<min){
                        index=i;
                        min=dis[i];
                    }
                }
            }
            if(index==-1) break;
            visited[index]=true;
            for(int i=0;i<graph.length;i++){
                if(graph[index][i]!=Integer.MAX_VALUE){
                    dis[i]= dis[i]<(min+graph[index][i])?dis[i]:min+graph[index][i];
                }
            }
        }
    }

    public static void main(String args[]){
        int[][] graph=new int[][]{
                {0,Integer.MAX_VALUE,10,Integer.MAX_VALUE,30,100},
                {Integer.MAX_VALUE,0,5,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,0,50,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,10},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,20,0,60},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};

        int[] dis = new int[graph.length];
        boolean[] vistied = new boolean[graph.length];
        vistied[0] = true;
        for (int i = 0;i<graph[0].length;i++){
            dis[i] = graph[0][i];
        }
        Dijkstra d = new Dijkstra();
        d.dijkstra(graph, dis, vistied);
        for(int i=0;i<dis.length;i++)
            System.out.print(dis[i]+" ");
    }
}
