import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 8)
MAX = 100001
MIN = -1
TREE_DEPTH = 0


def get_pre_order(left, right, depth):
    global TREE_DEPTH, pre_tree, post_tree, level, pre_order, post_order
    if depth == TREE_DEPTH:
        return
    if len(pre_tree[level[depth]]) == 0:
        return
    if not (left < pre_tree[level[depth]][-1][0] < right):
        return

    x, id = pre_tree[level[depth]].pop()
    pre_order.append(id)
    get_pre_order(left, x, depth + 1)
    get_pre_order(x, right, depth + 1)


def get_post_order(left, right, depth):
    global TREE_DEPTH, pre_tree, post_tree, level, pre_order, post_order
    if depth == TREE_DEPTH:
        return
    if len(post_tree[level[depth]]) == 0:
        return
    if not (left < post_tree[level[depth]][-1][0] < right):
        return

    x, id = post_tree[level[depth]].pop()
    get_post_order(left, x, depth + 1)
    get_post_order(x, right, depth + 1)
    post_order.append(id)


def solution(nodeinfo):
    global TREE_DEPTH, pre_tree, post_tree, level, pre_order, post_order
    pre_tree = defaultdict(list)
    post_tree = defaultdict(list)
    level = set()

    for i, (x, y) in enumerate(nodeinfo):
        pre_tree[y].append((x, i + 1))
        post_tree[y].append((x, i + 1))
        level.add(y)

    for pre, post in zip(pre_tree, post_tree):
        pre_tree[pre].sort(reverse=True)
        post_tree[post].sort(reverse=True)

    level = sorted(list(level), reverse=True)
    TREE_DEPTH = len(level)
    pre_order = []
    get_pre_order(MIN, MAX, 0)
    post_order = []
    get_post_order(MIN, MAX, 0)

    return [pre_order, post_order]


nodeinfo = [[5, 3], [11, 5], [13, 3], [3, 5], [6, 1], [1, 3], [8, 6], [7, 2], [2, 2]]
print(solution(nodeinfo))