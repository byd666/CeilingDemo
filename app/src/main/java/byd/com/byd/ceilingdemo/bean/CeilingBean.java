package byd.com.byd.ceilingdemo.bean;

import java.util.List;

/**
 * @author：byd666 on 2017/12/2 15:20
 */

public class CeilingBean {

    public static class BaseBean {
        private String gName;
        private String gid;
        private long createTime;
        private String uname;
        public long getCreateTime() {
            return createTime;
        }
        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public void setgName(String gName) {
            this.gName = gName;
        }

        public String getgName() {
            return gName;
        }
    }

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<FirstBean> f;
        private List<SecondBean> s;
        private List<ThirdBean> t;

        public List<FirstBean> getFirst() {
            return f;
        }

        public void setFirst(List<FirstBean> f) {
            this.f = f;
        }

        public List<SecondBean> getSecond() {
            return s;
        }

        public void setSecond(List<SecondBean> image) {
            this.s = s;
        }

        public List<ThirdBean> getThird() {
            return t;
        }

        public void setThird(List<ThirdBean> video) {
            this.t = t;
        }

        public static class FirstBean extends BaseBean {
            private String fid;
            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }
        }

        public static class SecondBean extends BaseBean {

            private String sid;

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }
        }
        public static class ThirdBean extends BaseBean {
            private String tid;
            public String getTid() {
                return tid;
            }
            public void setTid(String tid) {
                this.tid = tid;
            }

        }
    }
}
