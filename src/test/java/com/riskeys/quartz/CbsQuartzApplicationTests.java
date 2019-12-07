package com.riskeys.quartz;

import com.riskeys.quartz.util.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CbsQuartzApplicationTests {

    @Test
    public void contextLoads() {
        for (int i = 0; i < 3; i++) {
            log.info(UuidUtils.base58Uuid().toString());
        }
    }

}

