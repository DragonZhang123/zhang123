package lamda;

import java.io.BufferedReader;

/**
 * 唯一的抽象方法 函数式接口
 */
@FunctionalInterface
public interface IBufferedReaderProcesser {
    String process(BufferedReader bufferedReader) throws Exception;
}
