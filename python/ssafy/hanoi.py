# 하노이탑 (재귀)

def hanoi(n, frm, to, sub):
    if n == 1:
        print(f'{frm} -> {to}')
        return
    
    # 원반 n-1개를 sub 로 이동
    hanoi(n-1, frm, sub, to)
    print(f'{frm} -> {to}')
    hanoi(n-1, sub, to, frm)
    
# 원반 3개를 1번 기둥에서 3번 기둥으로 이동
hanoi(3, 1, 3, 2)