package com.wyw;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Captain {

    private RowingBoat rowingBoat;

    void row() {
        rowingBoat.row();
    }
}
