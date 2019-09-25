import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/25 17:06
 * @description：
 * @modified By：
 */
public class LogTest {

    Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void printLog() {
        logger.info("info[{}]","123");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
    }

}
