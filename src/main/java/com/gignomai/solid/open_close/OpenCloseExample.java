package com.gignomai.solid.open_close;

import java.util.Random;

interface PlayerMovement {
    int moves(int movementRange);
}

class Player {
    public static final void move(int movementRange, PlayerMovement playerMovement) {
        System.out.println(playerMovement.moves(movementRange));
    }
}

class WizardMovement implements PlayerMovement {
    @Override
    public int moves(int movementRange) {
        return movementRange - 1;
    }
}

class RangerMovement implements PlayerMovement {
    @Override
    public int moves(int movementRange) {
        return movementRange * 2;
    }
}

class DwarfMovement implements PlayerMovement {
    @Override
    public int moves(int movementRange) {
        return movementRange / 2;
    }
}

// By defining PlayerMovement as an interface we open player method 'move' for extension but keep it closed for modification.
// Now we don't need to modify 'move' method any time that we need to add a new type of movement.
public class OpenCloseExample {
    public static void main (String[] args) {
        Random random = new Random();
        int moveRange = random.nextInt(10);
        Player.move(moveRange, new WizardMovement());
        Player.move(moveRange, new RangerMovement());
        Player.move(moveRange, new DwarfMovement());

    }
}
