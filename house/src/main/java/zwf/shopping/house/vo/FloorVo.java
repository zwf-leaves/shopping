package zwf.shopping.house.vo;

import lombok.Data;
import zwf.shopping.house.entity.FloorListEntity;
import zwf.shopping.house.entity.FloorTitleEntity;

import java.util.List;

/**
 * @author zwf
 * @create 2021-04-10-15:34
 */
@Data
public class FloorVo {
    private FloorTitleEntity titleEntity;
    private List<FloorListEntity> listEntities;
}
