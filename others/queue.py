from collections import deque

queue = deque()
for i in range(5): queue.append(i+1)
queue_pop = queue.popleft()
queue = list(queue)

stack = []
for i in range(5): stack.append(i+1)
stack_pop = stack.pop()

print('Queue :', queue, queue_pop)
print('Stack :', stack, stack_pop)