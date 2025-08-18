# Farm System UML Class Diagram

```mermaid
classDiagram
    %% Core Interfaces
    class Eater {
        <<interface>>
        +eat(Edible)
    }
    
    class NoiseMaker {
        <<interface>>
        +makeNoise()
    }
    
    class Rideable {
        <<interface>>
    }
    
    class Rider {
        <<interface>>
        +mount(Rideable)
        +dismount(Rideable)
    }
    
    class Botanist {
        <<interface>>
        +plant(Crop, CropRow)
    }
    
    class Produce~T~ {
        <<interface>>
        +yield() T
    }
    
    class Edible {
        <<interface>>
    }
    
    %% Abstract Base Classes
    class Animal {
        <<abstract>>
    }
    
    class Vehicle {
        <<abstract>>
    }
    
    class Crop~T~ {
        <<abstract>>
        -hasBeenHarvested: boolean
        -hasBeenFertilized: boolean
    }
    
    class Shelter~T~ {
        <<abstract>>
        -residents: ArrayList~T~
        +addResident(T resident)
        +getResidents() ArrayList~T~
    }
    
    %% People
    class Person
    class Farmer
    class Pilot
    
    %% Animals
    class Horse
    class Chicken {
        -hasBeenFertilized: boolean
        +yield() EdibleEgg
    }
    
    %% Vehicles
    class Tractor~T~ {
        +harvest(T) T
    }
    
    class CropDuster~T~ {
        +fly()
        +fertilize(CropRow~T~)
    }
    
    %% Crops & Food
    class CornStalk
    class TomatoPlant
    class EdibleEgg
    class EarCorn
    class Tomato
    
    %% Containers
    class CropRow~T~ {
        -crops: List~T~
    }
    
    class Field~T~ {
        -cropRows: List~CropRow~T~~
    }
    
    class Stable~T~ {
    }
    
    class ChickenCoop~T~ {
    }
    
    class FarmHouse~T~ {
    }
    
    class Farm {
        -field: Field~Crop~
    }
    
    %% Inheritance
    Animal --|> NoiseMaker
    Animal --|> Eater
    
    Horse --|> Animal
    Horse --|> Rideable
    
    Chicken --|> Animal
    Chicken --|> Produce~EdibleEgg~
    
    Vehicle --|> NoiseMaker
    Vehicle --|> Rideable
    
    Tractor~T~ --|> Vehicle
    CropDuster~T~ --|> Vehicle
    
    Stable~T~ --|> Shelter~T~
    ChickenCoop~T~ --|> Shelter~T~
    FarmHouse~T~ --|> Shelter~T~
    Farm --|> Shelter~Object~
    
    Crop~T~ --|> Produce~T~
    
    CornStalk --|> Crop~EarCorn~
    TomatoPlant --|> Crop~Tomato~
    
    Person --|> NoiseMaker
    Person --|> Eater
    
    Farmer --|> Person
    Farmer --|> Rider
    Farmer --|> Botanist
    
    Pilot --|> Person
    Pilot --|> Rider
    
    EdibleEgg --|> Edible
    EarCorn --|> Edible
    Tomato --|> Edible
    
    %% Composition
    Farm --* Field~Crop~
    Field~T~ --* CropRow~T~
    CropRow~T~ --* Crop~T~
    Shelter~T~ --* T
```

## Streamlined Design Features:

### **Core Concepts:**
- **Interfaces**: Define behavioral contracts (`Eater`, `NoiseMaker`, `Rideable`, etc.)
- **Generics**: Type-safe collections and producers (`Produce<T>`, `Crop<T>`, containers)
- **Inheritance**: Clean hierarchies avoiding multiple inheritance issues
- **Composition**: Farm contains specialized buildings and structures

### **Key Simplifications:**
1. **Removed verbose method signatures** - Focus on essential structure
2. **Consolidated vehicle hierarchy** - Simplified to core functionality
3. **Streamlined relationships** - Used composition (--*) for stronger ownership
4. **Essential attributes only** - Key fields like `hasBeenHarvested`, `hasBeenFertilized`
5. **Conditional Production** - `Chicken` yields `EdibleEgg` only when `hasBeenFertilized` is false

### **Generic Benefits:**
- `Produce<T>` ensures type-safe yielding
- Container classes (`CropRow<T>`, `Stable<T>`) work with any appropriate type
- `Tractor<T>` and `CropDuster<T>` are reusable for different crop types
- Compile-time type safety prevents runtime errors

This concise UML maintains all essential farm system relationships while demonstrating clean generic design patterns.
