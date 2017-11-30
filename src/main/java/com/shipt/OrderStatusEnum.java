package com.shipt;

public enum OrderStatusEnum {

PLACED(0),
DELIVERING(1),
DELIVERED(2);

private final int value;   

	OrderStatusEnum(int value) {
    this.value= value;
}


}
