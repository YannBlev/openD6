package bzh.amzerin.openD6.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CharacterForm {

    private String characterName;

    private List<AttributeForm> attributes = new ArrayList<>();
}