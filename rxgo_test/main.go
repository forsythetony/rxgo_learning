package main

import (
	"context"
	"fmt"

	"github.com/reactivex/rxgo/v2"
)

func main() {

	rxTest()
}

func rxTest() {

	fmt.Println("Testing out the RxGo library!")

	//	Create the observable
	observable := rxgo.Just(1, 2, 3, 4, 5, 6)().
		Map(times10).
		Filter(greaterThan30)

	for item := range observable.Observe() {

		if item.Error() {
			fmt.Println("Do something... error :: ", item.E)
		}

		fmt.Println("Items are :: ", item.V)
	}
}

func times10(ctx context.Context, i interface{}) (interface{}, error) {

	return i.(int) * 10, nil
}

func greaterThan30(i interface{}) bool {
	return i.(int) > 30
}
