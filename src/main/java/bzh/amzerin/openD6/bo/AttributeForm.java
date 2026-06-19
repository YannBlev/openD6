package bzh.amzerin.openD6.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AttributeForm {

    private int attributeId;
    private int pipValue;
    
    private List<SkillForm> skills = new ArrayList<>();
}