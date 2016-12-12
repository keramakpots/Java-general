import sys
numb = open(sys.argv[1], 'r')
def bubble_sort(to_sort):
    x = 0
    while x  0:
        for i in range(len(to_sort)-1):
            if to_sort[i] > to_sort[i + 1]:
                lower_num = to_sort[i + 1]
                higher_num = to_sort[i]
                to_sort[i] = lower_num
                to_sort[i + 1] = higher_num
                x+=1
    return to_sort

def creating_list(numb):
    numb1 = []
    reader = numb.readlines()
    for i in reader:
        numb1.append(int(i))
    return numb1




print(bubble_sort(creating_list(numb)))
