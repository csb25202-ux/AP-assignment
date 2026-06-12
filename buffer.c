#include <stdio.h>  // For printf
#include <stdlib.h> // For malloc, realloc, free, size_t
#include <string.h> // For strlen, strcat

// --- 1. The Blueprint ---
typedef struct {
    char *data;
    size_t length;
    size_t capacity;
} StringBuffer;

// --- 2. The Spawn Point ---
StringBuffer* sb_init(size_t initial_capacity) {
    StringBuffer *sb = (StringBuffer*)malloc(sizeof(StringBuffer));
    if (sb == NULL) return NULL;

    sb->data = (char*)malloc((initial_capacity + 1) * sizeof(char));
    if (sb->data == NULL) {
        free(sb);
        return NULL;
    }

    sb->capacity = initial_capacity;
    sb->length = 0;
    sb->data[0] = '\0';
    return sb;
}

// --- 3. The Boss Fight (Expansion) ---
void sb_append(StringBuffer *sb, const char *str) {
    if (sb == NULL || str == NULL) return;

    size_t str_len = strlen(str);
    size_t new_total_len = sb->length + str_len;

    if (new_total_len >= sb->capacity) {
        size_t new_capacity = sb->capacity;
        
        while (new_capacity <= new_total_len) {
            new_capacity *= 2; // Keep doubling
        }

        char *temp = (char*)realloc(sb->data, (new_capacity + 1) * sizeof(char));
        if (temp == NULL) return; 

        sb->data = temp;
        sb->capacity = new_capacity;
    }

    strcat(sb->data, str);
    sb->length = new_total_len;
}

// --- 4. The Clean Exfiltration ---
void sb_free(StringBuffer *sb) {
    if (sb == NULL) return;
    if (sb->data != NULL) free(sb->data);
    free(sb);
}

// --- TEST ARENA ---
int main() {
    printf("--- MISSION START ---\n\n");

    // Spawn a buffer with a very small capacity of 2
    StringBuffer *sb = sb_init(2);
    printf("[INIT]   Capacity: %zu, Length: %zu, Data: '%s'\n", sb->capacity, sb->length, sb->data);

    // Append 1: Fits easily (Length 1 < Capacity 2)
    sb_append(sb, "A");
    printf("[APPEND] Capacity: %zu, Length: %zu, Data: '%s'\n", sb->capacity, sb->length, sb->data);

    // Append 2: Forces First Growth! 
    // "BC" makes total length 3. Capacity 2 doubles to 4.
    sb_append(sb, "BC");
    printf("[GROW 1] Capacity: %zu, Length: %zu, Data: '%s'\n", sb->capacity, sb->length, sb->data);

    // Append 3: Forces Second Growth!
    // "DEFGH" makes total length 8. Capacity 4 doubles to 8, but 8 <= 8, so it doubles again to 16.
    sb_append(sb, "DEFGHI  ");
    printf("[GROW 2] Capacity: %zu, Length: %zu, Data: '%s'\n", sb->capacity, sb->length, sb->data);

    // Clean up
    sb_free(sb);
    printf("\n--- MISSION ACCOMPLISHED: All memory freed ---\n");

    return 0;
}