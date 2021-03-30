## What is BIOS?

BIOS
stands for (Basic Input Output System)
it is a firmware (give permanent instructions to hardware device,stored in flash ROM,can be erased and re-written)
helps in hardware intitialization during the booting process
helps in runtime services for os and programms
how BIOS boots the system?
in order to boot the system following procedure is followed
a) first the POST (Power on Self Test) is called and it Checks for the BIOS

b) then the BIOS check for the CMOS-RAM(it saves the BIOS settings in it )

c) after this the hardware components are checked

d) bios then check for MBR(it stores the information in first sector of any hard disk and helps in finding the location of OS storage)

e) finally BOOT LOADER is retreived and the RAM is assigned to the OS

f) OS is booted

example of BIOS: AWARD,AMI,PHOENIX

how we can update our BIOS chips ?

in order to update them we can use two methods

a) flash them (software method)

b) programme them with EEPROM ( hardware method)

limitations of BIOS

a) can only root upto 2TB memory device (?)

b) runs in 16 bit processor only

c) BIOS initiates a series of bootloader which becomes complex as it loads more and more.
It cannot load OS directly. As it cannot handle file structure.

## What is UEFI?

UEFI stands for Unified Extensible Firmaware Interface
uefi is a low level software that help in the booting the cpu
(acc to a report INTEL has announced to remove all BIOS chips with UEFI by 2020)
how uefi is different from bios?
a) support larger drives(2.2TB -9.4 ZB)
b) fatser booting times
c) enhanced security
d) better UI
it maintains a list of valid boot volumes called EFI service partition
instead of using MBR it uses GPT (GUILD PARTITION TABLE)
what is GPT?
it is a standard for the layout of partition tables used in storage devices
a) gpt uses logical block addressing[LBA] instead of the historical cyclinder-head-sector.[CHS]
b) gpt does not have a boot -loader
c) gpt is not constrained by temporary schemes such as container partitions
how uefi boots the system ?

it scans the GPT to find a EFI(Extensible Firmware Interface)(partition on storage device)
after scanning it directly loads the OS from the right postions
in case it is not able to find the correct position it goes for LEGACY BOOT (booting by BIOS)

resource: https://leetcode.com/discuss/interview-question/operating-system/763373/BIOS-AND-UEFI

https://www.cs.rutgers.edu/~pxk/416/notes/02-boot.html
