package solution.acm;

import java.util.Arrays;

public class Interval {


    public static void main(String args[]){
        Work[] works = {
                new Work(1, 3),
                new Work(2, 5),
                new Work(4, 7),
                new Work(6, 9),
                new Work(8, 10)
        };
        int result = interval(works);
        System.out.println(result);
    }

    private static int interval(Work[] works) {
        Arrays.sort(works);
        int count = 0;
        // 当前工作的结束时间
        int t = 0;
        for (int i = 0; i < works.length; i++) {
            if (t < works[i].getStart()) {
                count++;
                t = works[i].getTerminate();
            }
        }
        return count;
    }


    public static class Work implements Comparable{

        private int start;

        private int terminate;

        Work(int start, int terminate) {
            this.start = start;
            this.terminate = terminate;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getTerminate() {
            return terminate;
        }

        public void setTerminate(int terminate) {
            this.terminate = terminate;
        }

        @Override
        public int compareTo(Object o) {
            Work work = (Work)o;
            if (this.terminate > work.getTerminate())
                return 1;
            else if (this.terminate == work.getTerminate())
            return 0;
            else
                return -1;
        }
    }
}
