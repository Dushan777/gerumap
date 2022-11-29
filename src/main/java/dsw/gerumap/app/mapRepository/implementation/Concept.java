package dsw.gerumap.app.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Concept extends Element{

    private String name;
    private int size;
    private Point position;
}
