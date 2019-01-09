package medium.ValidateIPAddress;

/**
 * @author YangShuo
 * @create 2019/1/9
 * @comment
 */
public class judgeIPAddress {
    public String validIPAddress(String IP) {

        if(isIPv4(IP)) return "IPv4";
        else if(isIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    public boolean isIPv4(String ip){
        boolean flag = true;
        if(ip.length() < 7) return false;
        if(ip.charAt(ip.length() - 1) == '.') return false;
        if(ip.indexOf(".") != -1 && ip.indexOf(":") == -1){
            String[] splits = ip.split("\\.");
            if(splits.length == 4){
                for(int i = 0; i < 4; i ++){
                    flag = validIPv4Segment(splits[i]);
                    if(!flag) break;
                }
            }else
                flag = false;
        }else
            flag = false;

        return flag;
    }

    public boolean validIPv4Segment(String segment){
        boolean flag = true;
        if(segment.length() == 0) return false;
        if(segment.length() > 3) return false;
        if(segment.length() !=1 && segment.startsWith("0"))return false;

        for(int i = 0; i < segment.length(); i ++)
            if((segment.charAt(i) - '0') * (segment.charAt(i) - '9') > 0) return false;
        int value = Integer.parseInt(segment);
        if(value > 255) return false;

        return flag;
    }

    public boolean isIPv6(String ip){
        boolean flag = true;
        if(ip.length() < 7) return false;
        if(ip.charAt(ip.length() - 1) == ':') return false;
        if(ip.indexOf(".") == -1 && ip.indexOf(":") != -1){
            String[] splits = ip.split(":");
            if(splits.length == 8){
                for(int i = 0; i < 8; i ++){
                    flag = validIPv6Segment(splits[i]);
                    if(!flag) break;
                }
            }else
                flag = false;
        }else
            flag = false;

        return flag;
    }

    public boolean validIPv6Segment(String segment){
        boolean flag = true;
        if(segment.length() == 0) return false;
        if(segment.length() > 4) return false;
        segment = segment.toLowerCase();
        for(int i = 0 ; i < segment.length(); i ++){
            char ch = segment.charAt(i);
            if(!Character.isDigit(ch)){
                if((segment.charAt(i) - 'a') * (segment.charAt(i) - 'f') > 0) return false;
            }
        }
        return flag;


    }
}
