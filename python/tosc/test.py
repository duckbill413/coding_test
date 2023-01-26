from typing import Union
a: int = 1.30
b: int = 30


def add(first: int, second: int) -> int:
    return first + second


def toString(num: Union[int, float]) -> str:
    return str(num)


num = 'asdfas'

print(add(a, b))
print(toString(num))