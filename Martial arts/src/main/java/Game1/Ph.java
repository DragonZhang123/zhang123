package Game1;

import sun.rmi.runtime.Log;

/**
 * Created by zhang on 2018/2/9.
 */
public class Ph {
    Long id ;
    String phname;
    String phvalue;
    String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhname() {
        return phname;
    }

    public void setPhname(String phname) {
        this.phname = phname;
    }

    public String getPhvalue() {
        return phvalue;
    }

    public void setPhvalue(String phvalue) {
        this.phvalue = phvalue;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
