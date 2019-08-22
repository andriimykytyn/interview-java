package interview.dto.mapper;

import interview.dto.CheckDto;
import interview.entity.Check;
import org.springframework.stereotype.Component;

@Component
public class CheckDtoMapper {

    public Check getCheck(CheckDto checkDto) {
        Check check = new Check();
        check.setId(checkDto.getId());
        check.setTotalPrice(checkDto.getTotalPrice());
        check.setCreated(checkDto.getCreated());
        check.setCustomerId(checkDto.getCustomerId());
        return check;
    }

}
