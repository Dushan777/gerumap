package dsw.gerumap.app.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Concept extends Element{

    private String text;
    private int size, x, y;
}
