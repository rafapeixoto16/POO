package src;

import src.Mala;

public class MalaPremium extends Mala implements Premium {
    @Override
    public double precoPremium() {
        return 0;
    }
}
