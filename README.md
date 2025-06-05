# widgets
## Overview
 The project contains code for a Widget Machine emulator which uses an engine to produce widgets.
 The widgets are produced on demand, with the required quantity specified by the customer. The emulator calculates the cost of the production run, and returns this value. The cost is based on the quantity of widgets requested and the type of engine used – different engines produce widgets in different batch sizes and the cost per batch depends on the type of fuel used.
 
 The Widget Machine emulator currently supports an internal combustion engine which can be configured to use two types of fuel – petrol or diesel:
 - The batch size of an internal combustion engine is 8
 - The cost per batch is £9.00 if petrol is used and £12.00 if diesel is used
## Task
 Your task is to implement a new type of engine – a steam engine.
 - The properties of a steam engine are:
 - It supports only two types of fuel – wood and coal (it cannot be filled with any other type of fuel)
 - The cost per batch is £4.35 if wood is used, and £5.65 if coal is used
 - The batch size of a steam engine is 2
 - In order to start, a steam engine must meet the following conditions:
 - The fuel level must be greater than zero
 - The engine must have been filled with the required fuel type (engines are always empty when first created)
 - Engines must be initialised to use one fuel type before being started for the first time
 - Modify the Widget Machine to be able to use your new steam engine (it must continue to support the existing engines)
 - In order to start a production run, the Widget Machine must first start the engine and ensure it is running. Once production is finished, it must stop the engine
 - You are welcome to refactor the code as you see fit, but the Widget Machine must expose a method called produceWidgets which accepts the number of widgets to produce and returns the cost of the production run
