const testArr = [7, 3, 1, 4, 1]
const testArr2 = [7, 3, 1, 4, 6]

const containsDuplicate = nums => {
    const container = []
    for (let i = 0; i < nums.length; i++) {
        if (!container.includes(nums[i])) {
            container.push(nums[i])
        } else return true
    }
    return false
}

console.log('containsDuplicate(testArr) :=>', containsDuplicate(testArr))
console.log('containsDuplicate(testArr2) :=>', containsDuplicate(testArr2))
// containsDuplicate(testArr) :=> true
// containsDuplicate(testArr2) :=> false
