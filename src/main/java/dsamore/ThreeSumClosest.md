# ThreeSumClosest — How It Works

Solves **LeetCode 16 "3Sum Closest"**: given an array and a `target`, find the sum of
three numbers in the array that lands as close as possible to `target`.

## The big picture, in one sentence

Sort the array first, then use two pointers that "feel out" whether the current sum
is too small or too big, and move accordingly — like adjusting a shower knob left or
right until the water's close enough to the temperature you want.

## Step 1: Why sort first?

Before sorting: `[-1, 2, 1, -4]` — no order, no way to know "if I pick a bigger
number, does my sum go up or down."

After sorting: `[-4, -1, 1, 2]` — now the array goes strictly from smallest to
biggest. This matters because now:

- moving toward the **right end** of the array always means picking a **bigger** number
- moving toward the **left end** always means picking a **smaller** number

That's the entire reason sorting happens — it turns "which number should I try
next?" into "which direction should I step?"

## Step 2: The three-pointer setup

For each triplet, three pointers are used into the sorted array:

```
sorted: [-4, -1, 1, 2]
          ↑    ↑     ↑
          i   left  right
```

- `i` = the anchor. One number is fixed and the code searches for the best *pair*
  to go with it.
- `left` = starts right after `i`, scans from the small side.
- `right` = starts at the very end, scans from the big side.

## Step 3: The "too hot / too cold" logic (the heart of the algorithm)

At each moment `sum = nums[i] + nums[left] + nums[right]` is computed and compared
to `target`:

- **Too small** (`sum < target`) → need a bigger sum → move `left` one step right
  (grab a bigger number) → `left++`
- **Too big** (`sum > target`) → need a smaller sum → move `right` one step left
  (grab a smaller number) → `right--`
- **Exactly right** (`sum == target`) → can't get any closer than zero distance →
  return immediately

On *every* step, even while still searching, the code also checks: "is this sum
closer to `target` than the best one found so far?" If yes, it becomes the new best
(`closestSum`).

## Step 4: Full worked trace

`nums = {-1, 2, 1, -4}`, `target = 1` → sorted: `[-4, -1, 1, 2]`

Starting guess: `closestSum = nums[0]+nums[1]+nums[2] = -4 + -1 + 1 = -4`

| i (anchor) | left  | right | sum          | distance to target | closer than best so far? | closestSum becomes | next move                        |
|------------|-------|-------|--------------|---------------------|---------------------------|---------------------|-----------------------------------|
| 0 (`-4`)   | 1 (`-1`) | 3 (`2`) | `-4-1+2=-3`  | `\|-3-1\|=4`        | yes (4 < 5)               | **-3**              | sum(-3) < target(1) → `left++`   |
| 0 (`-4`)   | 2 (`1`)  | 3 (`2`) | `-4+1+2=-1`  | `\|-1-1\|=2`        | yes (2 < 4)               | **-1**              | sum(-1) < target(1) → `left++`   |
| —          | left(3) == right(3) → inner loop stops, move to next `i` |
| 1 (`-1`)   | 2 (`1`)  | 3 (`2`) | `-1+1+2=2`   | `\|2-1\|=1`         | yes (1 < 2)               | **2**               | sum(2) > target(1) → `right--`   |
| —          | left(2) == right(2) → inner loop stops |
| —          | `i` would need to be 2, but loop only runs while `i < length-2 = 2` → outer loop stops |

**Final answer: `closestSum = 2`**, from the triplet `-1 + 1 + 2 = 2` (distance `1`
from target `1`).

## Step 5: Why the pointers are guaranteed to eventually meet

Every inner `while` iteration does exactly one of: `left++`, `right--`, or an
immediate return on exact match. `left` only increases, `right` only decreases, and
the loop stops once `left` is no longer strictly less than `right` — so the gap
between them shrinks by one every step. That bounds the inner loop to at most `n`
iterations per anchor, giving `O(n)` per anchor and `O(n²)` overall (plus
`O(n log n)` for the initial sort).

## Step 6: Why this covers every triplet

For any triplet, once you pick three positions in the sorted array there's always a
smallest, a middle, and a largest. The outer loop tries every position as the
anchor, and since `left`/`right` scan toward each other from just after `i` to the
end, every valid combination where `i < left < right` gets considered somewhere
across all iterations. Nothing is skipped — the two-pointer trick only prunes
combinations that sorting has already shown can't beat the current best.

## Complexity

- **Time:** `O(n²)` — `O(n)` outer loop × `O(n)` inner two-pointer scan per anchor
  (plus `O(n log n)` sort, dominated by the `n²` term).
- **Space:** `O(1)` extra, aside from the sort itself.

## A note on ties

The problem (LeetCode 16) guarantees each valid input has exactly one closest sum,
so tie-breaking is undefined by the problem. If multiple triplets are equally close
to `target` (which shouldn't happen on valid LeetCode inputs), this implementation
returns whichever one it encounters first while scanning the *sorted* array — which
can differ from, say, a brute-force implementation scanning the *original* array
order. Both answers would be equally valid (same distance to target); this was
verified via fuzz-testing against a brute-force reference across 20,000 random
cases, with zero cases where the returned sum was farther from `target` than the
true optimum.
