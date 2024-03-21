def to_second(h, m, s):
    return 3600 * h + 60 * m + s

def is_overlap(h, m, s):
    h_angle = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360
    m_angle = m * 6 + s * 0.1
    s_angle = s * 6
    return h_angle == s_angle or m_angle == s_angle

def count_alarm(s):
    hour_count = int(s * 719 / 43200)
    minute_count = int(s * 59 / 3600)
    penalty = 0
    if s >= 12 * 3600: penalty += 1

    return 1 + hour_count + minute_count - penalty

def solution(h1, m1, s1, h2, m2, s2):
    start_second = to_second(h1, m1, s1)
    end_second = to_second(h2, m2, s2)
    diff_count = count_alarm(end_second) - count_alarm(start_second)

    if (is_overlap(h1, m1, s1)):
        return diff_count + 1
    return diff_count