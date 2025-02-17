class VersionControl {
    public static boolean isBadVersion(int version) {
        int badVersion = 4;
        return version >= badVersion;
    }
}

public class firstBadVersion extends VersionControl{

    //  278. First Bad Version

    public static int firstBadVersion(int n) {
        int front = 1;
        int rear = n;
        while (front < rear){
            int mid = front + (rear - front) / 2;
            if(isBadVersion(mid)){
                rear = mid;
            }else{
                front = mid + 1;
            }
        }
        return front;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("First bad version: " + firstBadVersion(n));
    }
}


