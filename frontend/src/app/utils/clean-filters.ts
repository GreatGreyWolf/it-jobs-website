export function cleanFilters(filters: any): any {
    const cleaned: { [key: string]: any } = {};
    for (const key in filters) {
        if (filters[key] !== undefined && filters[key] !== null && filters[key] !== '') {
            cleaned[key] = filters[key];
        }
    }
    return cleaned;
}
