.DEFAULT_GOAL := build-run

setup:
	make -C app setup

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C install

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

check-deps:
	make -C app check-deps


build-run: build run

.PHONY: build
