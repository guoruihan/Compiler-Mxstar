.text

.globl	_qpow__myfunc
.p2align	1
.type	_qpow__myfunc,@function

_qpow__myfunc:
	l_0:
	addi sp, sp, -4
	sw s0, 0(sp)
	mv s0, sp
	mv a4, a1
	mv a3, a2
	li a1, 1
	l_1:
	bgtz a4, l_2
	l_3:
	mv a0, a1
	l_4:
	mv sp, s0
	lw s0, 0(sp)
	addi sp, sp, 4
	lw ra, 0(sp)
	addi sp, sp, 4
	ret
	l_2:
	mv a2, a4
	li t1, 1
	and a2, a2, t1
	li t1, 1
	bne a2, t1, l_5
	l_6:
	mul a1, a1, a0
	rem a1, a1, a3
	l_5:
	mv a2, a0
	mul a2, a2, a0
	mv a0, a2
	rem a0, a0, a3
	li t1, 2
	div a4, a4, t1
	j l_1

.globl	_main__myfunc
.p2align	1
.type	_main__myfunc,@function

_main__myfunc:
	l_7:
	addi sp, sp, -4
	sw s0, 0(sp)
	mv s0, sp
	li a2, 10000
	li a1, 10
	li a0, 2
	addi sp, sp, -4
	sw ra, 0(sp)
	call _qpow__myfunc 
	addi sp, sp, -4
	sw ra, 0(sp)
	call toString 
	addi sp, sp, -4
	sw ra, 0(sp)
	call println 
	li a0, 0
	l_8:
	mv sp, s0
	lw s0, 0(sp)
	addi sp, sp, 4
	lw ra, 0(sp)
	addi sp, sp, 4
	ret

.globl	main
.p2align	1
.type	main,@function

main:
	l_9:
	addi sp, sp, -4
	sw s0, 0(sp)
	mv s0, sp
	addi sp, sp, -4
	sw ra, 0(sp)
	call _main__myfunc 
	mv sp, s0
	lw s0, 0(sp)
	addi sp, sp, 4
	lw ra, 0(sp)
	addi sp, sp, 4
	ret

