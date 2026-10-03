# Assignment 3 – Bridge Pattern

**Student:** Yerkezhan Balagazinova  
**Group:** [SE-2527]  
**Topic:** A – Drawing  
**Repository:** https://github.com/YerkezhanBalagazinova/SDP_A3  
**Base commit:** `89959198e78f57476e484bafc71a4143d535fd8a`

## Role Map

| Role | Class | Source Path |
|---|---|---|
| Abstraction | Shape | `src/Shape.java` |
| A1 | Circle | `src/Circle.java` |
| A2 | Square | `src/Square.java` |
| Implementor | Renderer | `src/Renderer.java` |
| I1 | VectorRenderer | `src/VectorRenderer.java` |
| I2 | RasterRenderer | `src/RasterRenderer.java` |
| I3 | AsciiRenderer | `src/AsciiRenderer.java` |
| Client | Main | `src/Main.java` |

## Important Code Locations

### Bridge Field

The bridge field is located in `src/Shape.java`:

```java
protected Renderer renderer;
```

This field connects the abstraction side with the implementation side.

### execute()

The `execute()` method is declared in `src/Shape.java` and implemented in:

- `src/Circle.java`
- `src/Square.java`

Circle:

```java
@Override
public String execute() {
    return renderer.renderCircle(radius);
}
```

Square:

```java
@Override
public String execute() {
    return renderer.renderSquare(side);
}
```

### setImplementation(...)

The runtime implementation switch is located in `src/Shape.java`:

```java
public void setImplementation(Renderer renderer) {
    this.renderer = renderer;
}
```

It allows the same Shape object to use another Renderer at runtime.

### T5 Check

The T5 runtime switching check is located in `src/Main.java`.

T5 checks that:

- the same Circle object is used before and after the switch;
- object identity is checked using `==`;
- the ID stays unchanged;
- the radius stays unchanged;
- the renderer changes from `VectorRenderer` to `RasterRenderer`;
- the output changes after the implementation switch.

## Compile

Run this command from the project folder:

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

## Run

```bash
java -cp out Main --demo
```

The demo does not require any interactive input.

## Expected Results

### T1 – Circle + VectorRenderer

```text
VECTOR circle radius=2
```

### T2 – Circle + RasterRenderer

```text
RASTER circle radius=2
```

### T3 – Square + VectorRenderer

```text
VECTOR square side=3
```

### T4 – Square + RasterRenderer

```text
RASTER square side=3
```

### T5 – Runtime Implementation Switch

The same Circle object first uses `VectorRenderer` and then changes to `RasterRenderer`.

Expected state:

```text
sameObject=true
stateUnchanged=true
before=VECTOR circle radius=2
after=RASTER circle radius=2
```

### T6 – Circle + AsciiRenderer

```text
ASCII circle radius=2
```

### T7 – Square + AsciiRenderer

```text
ASCII square side=3
```

## Expected Final Summary

```text
SUMMARY: 7/7 PASS
```
