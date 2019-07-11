package ru.jihor.example.mocks;

import com.system_a.fico_scoring.FicoRequestType;
import com.system_a.fico_scoring.FicoResponseType;
import com.system_a.fico_scoring.FicoService;
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
public class FicoServiceImpl implements FicoService {
    @Override
    public Response<FicoResponseType> getScoreAsync(FicoRequestType ficoRequest) {
        return getServerAsyncResponse(ficoRequest);
    }

    @Override
    public Future<?> getScoreAsync(FicoRequestType ficoRequest, AsyncHandler<FicoResponseType> asyncHandler) {
        return CompletableFuture.runAsync(
                () -> asyncHandler.handleResponse(getServerAsyncResponse(ficoRequest)));
    }

    private ServerAsyncResponse<FicoResponseType> getServerAsyncResponse(FicoRequestType ficoRequest) {
        ServerAsyncResponse<FicoResponseType> asyncResponse = new ServerAsyncResponse<>();
        asyncResponse.set(getScore(ficoRequest));
        return asyncResponse;
    }

    @Override
    public FicoResponseType getScore(FicoRequestType ficoRequest) {
        FicoResponseType response = new FicoResponseType();
        BigDecimal age = new BigDecimal(ficoRequest.getAge());
        BigDecimal startValue = BigDecimal.valueOf(600);
        response.setScore(startValue.subtract(age));
        return response;
    }
}
