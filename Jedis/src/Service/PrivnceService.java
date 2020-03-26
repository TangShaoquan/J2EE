package Service;

import domain.Province;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface PrivnceService {
    public List<Province> findall();
    public String findallFromRedis();
}
