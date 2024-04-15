MAX_N = 100001
MAX_D = 22

n, q = 0, 0  # 채팅방 수, 명령의 수
a, p, val = [0] * MAX_N, [0] * MAX_N, [0] * MAX_N  # authority, power, 총 알림 수
noti = [False] * MAX_N  # 알림 ON/OFF ON: False, OFF: True
nx = [[0 for j in range(MAX_D)] for i in range(MAX_N)]  # 각 채팅방 노드마다, 해당 노드가 전달할 수 있는 알림의 수


# 초기 설정
def init(inputs):
    global n, a, p, val, nx
    # 부모 채팅과 채팅의 권한 입력
    for i in range(1, n + 1):
        p[i] = inputs[i]

    for i in range(1, n + 1):
        a[i] = inputs[n + i]
        if a[i] > 20:
            a[i] = 20

    # nx 배열과 val 값 초기화
    for i in range(1, n + 1):
        cur = i
        x = a[i]  # 권한
        nx[cur][x] += 1  # 전달 가능한 알림의 수
        while p[cur] and x:  # 부모가 있으면서, 권한이 0이 아닌 경우
            cur = p[cur]
            x -= 1
            if x:
                nx[cur][x] += 1
            val[cur] += 1


# 알림 상태 토클
def toggle_noti(chat):
    cur = p[chat]
    num = 1
    # 상위 채팅으로 이동하며 noti 값에 따라 nx와 val 값을 갱신
    while cur:  # 부모 탐색
        for i in range(num, MAX_D):
            val[cur] += nx[chat][i] if noti[chat] else -nx[chat][i]  # 알림 상태
            if i > num:
                nx[cur][i - num] += nx[chat][i] if noti[chat] else - nx[chat][i]
        if noti[cur]:
            break
        cur = p[cur]
        num += 1
    noti[chat] = not noti[chat]


# 권한 업데이트
def change_power(chat, power):
    prev_power = a[chat]
    power = min(power, 20)
    a[chat] = power

    nx[chat][prev_power] -= 1
    if not noti[chat]:
        cur = p[chat]
        num = 1
        # 상위 채팅으로 이동하면서 nx와 val 값을 갱신
        while cur:
            if prev_power >= num:
                val[cur] -= 1
            if prev_power > num:
                nx[cur][prev_power - num] -= 1
            if noti[cur]:
                break
            cur = p[cur]
            num += 1

    nx[chat][power] += 1
    if not noti[chat]:
        cur = p[chat]
        num = 1
        while cur:
            if power >= num:
                val[cur] += 1
            if power > num:
                nx[cur][power - num] += 1
            if noti[cur]:
                break
            cur = p[cur]
            num += 1


def change_parent(chat1, chat2):
    prev_noti1 = noti[chat1]
    prev_noti2 = noti[chat2]

    if not noti[chat1]:
        toggle_noti(chat1)
    if not noti[chat2]:
        toggle_noti(chat2)

    p[chat1], p[chat2] = p[chat2], p[chat1]

    if not prev_noti1:
        toggle_noti(chat1)
    if not prev_noti2:
        toggle_noti(chat2)


def print_count(chat):
    print(val[chat])


n, q = map(int, input().split())
for _ in range(q):
    inputs = list(map(int, input().split()))
    query = inputs[0]
    # 초기화
    if query == 100:
        init(inputs)
    # 알림망 ON/OFF
    elif query == 200:
        chat = inputs[1]
        toggle_noti(chat)
    # 권한 세기 변경
    elif query == 300:
        chat, power = inputs[1], inputs[2]
        change_power(chat, power)
    # 부모 변경
    elif query == 400:
        chat1, chat2 = inputs[1], inputs[2]
        change_parent(chat1, chat2)
    # 전달 가능한 알림의 수
    elif query == 500:
        chat = inputs[1]
        print_count(chat)
