package me.erano.com.domain.value;

//value object for Event entity
public class Activity {

    //source
    private final String srcHost;
    //destination
    private final String dstHost;

    public Activity (String srcHost, String dstHost){
        this.srcHost = srcHost;
        this.dstHost = dstHost;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "srcHost='" + srcHost + '\'' +
                ", dstHost='" + dstHost + '\'' +
                '}';
    }
}
