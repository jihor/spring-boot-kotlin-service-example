package ru.jihor.example.mocks;

import com.system_a.fico_scoring.FicoRequestType;
import com.system_a.fico_scoring.FicoResponseType;
import com.system_a.fico_scoring.FicoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.ServerAsyncResponse;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author jihor (jihor@ya.ru)
 * Created on 09.07.2019
 */
@WebService(
        targetNamespace = "http://system-a.com/fico-scoring",
        name = "FicoService"
)
@Service
@Slf4j
public class FicoServiceImpl implements FicoService {
    @Override
    public Response<FicoResponseType> getScoreAsync(FicoRequestType ficoRequest) {
        log.error("getScoreAsync invoked");
        throw new RuntimeException("Should not reach here");
    }

    @Override
    public Future<?> getScoreAsync(FicoRequestType ficoRequest, AsyncHandler<FicoResponseType> asyncHandler) {
        log.error("getScoreAsync invoked");
        throw new RuntimeException("Should not reach here");
    }

    @Override
    public FicoResponseType getScore(FicoRequestType ficoRequest) {
        log.info("getScore invoked");
        FicoResponseType response = new FicoResponseType();
        BigDecimal age = new BigDecimal(ficoRequest.getAge());
        BigDecimal startValue = BigDecimal.valueOf(600);
        response.setScore(startValue.subtract(age));
        return response;
    }
}
