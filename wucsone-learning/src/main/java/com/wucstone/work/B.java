package com.wucstone.work;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class B {

//    private String name;
//
//    private String addr;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        B b = (B) o;
//        return Objects.equals(name, b.name) &&
//                Objects.equals(addr, b.addr);
//    }

    @Override
    public int hashCode() {
        return 31;
    }
}
