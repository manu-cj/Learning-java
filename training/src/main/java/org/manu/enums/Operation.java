package org.manu.enums;

public enum Operation {
    ADD {
        public int appliquer(int a, int b) {
            return a + b;
        }
    },

    MULTIPLY {
        public int appliquer(int a, int b) {
            return a * b;
        }
    };

    public abstract int appliquer(int a, int b);

}
