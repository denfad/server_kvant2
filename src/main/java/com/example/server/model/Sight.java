package com.example.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sight {
    private Long id;
    private String type;
    private String name;
    private String text;
    private double longitude;
    private double latitude;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sight sight = (Sight) o;
        return Objects.equals(id, sight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
