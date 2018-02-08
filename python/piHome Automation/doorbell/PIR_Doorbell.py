from gpiozero import MotionSensor
import pygame
from time import sleep


pir = MotionSensor(23)

pygame.init()
pygame.mixer.init()

door = pygame.mixer.Sound("piano2.wav")
while True:
    pir.wait_for_motion()
    print("Motion detected!")
    door.play()
    sleep(2)
    pir.wait_for_no_motion()
