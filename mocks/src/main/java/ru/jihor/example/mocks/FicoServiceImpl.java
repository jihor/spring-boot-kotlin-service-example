package ru.jihor.example.mocks;

import com.system_a.fico_scoring.FicoService;
import com.system_a.fico_scoring.Request;
import com.system_a.fico_scoring.Response;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.math.BigDecimal;

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
    public Response getScore(Request ficoRequest) {
        Response response = new Response();
        BigDecimal age = new BigDecimal(ficoRequest.getAge());
        BigDecimal startValue = BigDecimal.valueOf(600);
        response.setScore(startValue.subtract(age));
        return response;
    }
}
